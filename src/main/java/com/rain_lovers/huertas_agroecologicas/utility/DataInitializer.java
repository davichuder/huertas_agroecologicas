package com.rain_lovers.huertas_agroecologicas.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import com.rain_lovers.huertas_agroecologicas.enums.TagEnum;
import com.rain_lovers.huertas_agroecologicas.models.City;
import com.rain_lovers.huertas_agroecologicas.models.Comment;
import com.rain_lovers.huertas_agroecologicas.models.Country;
import com.rain_lovers.huertas_agroecologicas.models.Image;
import com.rain_lovers.huertas_agroecologicas.models.Post;
import com.rain_lovers.huertas_agroecologicas.models.Province;
import com.rain_lovers.huertas_agroecologicas.models.User;
import com.rain_lovers.huertas_agroecologicas.services.CityService;
import com.rain_lovers.huertas_agroecologicas.services.CommentService;
import com.rain_lovers.huertas_agroecologicas.services.CountryService;
import com.rain_lovers.huertas_agroecologicas.services.ImageService;
import com.rain_lovers.huertas_agroecologicas.services.PlantationStateService;
import com.rain_lovers.huertas_agroecologicas.services.PostService;
import com.rain_lovers.huertas_agroecologicas.services.ProvinceService;
import com.rain_lovers.huertas_agroecologicas.services.ResidenceService;
import com.rain_lovers.huertas_agroecologicas.services.RoleService;
import com.rain_lovers.huertas_agroecologicas.services.StateService;
import com.rain_lovers.huertas_agroecologicas.services.TagService;
import com.rain_lovers.huertas_agroecologicas.services.UserService;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleService roleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private PlantationStateService plantationStateService;

    @Autowired
    private StateService stateService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private ResidenceService residenceService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Override
    public void run(String... args) {
        roleService.loadRoles();
        tagService.loadTags();
        plantationStateService.loadPlantationStates();
        stateService.loadStates();

        Image image = imageService.saveProfile(null);

        countryService.saveCountry("Argentina");
        Country country = countryService.getCountryByName("Argentina");
        provinceService.saveProvince("Buenos Aires");
        Province province = provinceService.getProvinceByName("Buenos Aires");
        cityService.saveCity("Carlos Spegazzini");
        City city = cityService.getCityByName("Carlos Spegazzini");
        residenceService.saveResidence(country, province, city, "False Street", "Between Street 1 and Streeet 2", new Point(0, 0), 123);

        User user = userService.getUserByEmail("uno@uno.com");
        if (user == null) {
            user = userService.saveUser("uno@uno.com", "1234", "uno", "mattel");
        }

        Post post = postService.getPostByTitle("Titulo de prueba");
        if (post == null) {
            post = postService.savePost("Titulo de prueba", "Body de prueba", TagEnum.PROBLEM);
        }

        userService.addPost(user, post);

        Comment comment = commentService.getCommentByBody("Comentario de prueba");
        if (comment == null){
            comment = commentService.saveComment(user, "Comentario de prueba");
        }

        postService.addComment(post, comment);

        // Probar cargar residencia a un usuario, y una imagen
    }
}