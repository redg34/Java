package fr.aelion.streamer.controllers;

import fr.aelion.streamer.dto.FullCourseDto;
import fr.aelion.streamer.entities.Course;
import fr.aelion.streamer.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**@RestController
 * permet de retourner une réponse en json
 * Cette classe permet de traiter les requètes du front
 * @RequestMapping
 * toute requete api/v1  passera par ce controller
 * @GetMapping permet d'associer a une uri  a une méthode appelé de par tout ex: findAll
 * @Autowired appel la méthode
 */
@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    @Autowired
    private CourseService service;
    @GetMapping
    /**
     * ce dernier return renvoie tout
     */
    public List<FullCourseDto> findAll() {
        return  service.findAll();
    }
}
