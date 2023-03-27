package fr.aelion.streamer.services;

import fr.aelion.streamer.dto.FullCourseDto;

import java.util.List;

public interface CourseService<C> {
    List<FullCourseDto> findAll();

    FullCourseDto findOne(int id);


}
