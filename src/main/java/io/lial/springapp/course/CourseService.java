package io.lial.springapp.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String id) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(id).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course topic) {
        courseRepository.save(topic);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public void addAllCourses(List<Course> courses) {
        courseRepository.saveAll(courses);
    }
}
