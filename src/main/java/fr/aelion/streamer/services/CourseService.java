package fr.aelion.streamer.services;

import fr.aelion.streamer.dto.FullCourseDto;

import java.util.List;
import java.util.stream.Collectors;

public interface CourseService {

    public List<FullCourseDto> findAll();
}
