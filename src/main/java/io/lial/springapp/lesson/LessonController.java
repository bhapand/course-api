package io.lial.springapp.lesson;

import io.lial.springapp.course.Course;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String topicId, @PathVariable String courseId) {
        return lessonService.getAllLessons(courseId);
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public Lesson getLesson(@PathVariable String lessonId) {
        return lessonService.getLessonById(lessonId);
    }

    @PostMapping("topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson (@RequestBody Lesson lesson, @PathVariable String courseId, @PathVariable String topicId) {
        Course course = new Course(courseId, "","",topicId);
        lesson.setCourse(course);
        lessonService.addLesson(lesson);
    }

    @PostMapping("topics/{topicId}/courses/{courseId}/lessons/all")
    public void addLesson (@RequestBody List<Lesson> lessons, @PathVariable String courseId, @PathVariable String topicId) {
        Course course = new Course(courseId, "","",topicId);
        lessons.forEach(lesson -> lesson.setCourse(course));
        lessonService.addLessons(lessons);
    }

    @PutMapping("topics/{topicId}/courses/{courseId}/lessons")
    public void updateLesson (@RequestBody Lesson lesson, @PathVariable String courseId, @PathVariable String topicId) {
        lesson.setCourse(new Course(courseId, "","",topicId));
        lessonService.updateLesson(lesson);
    }

    @DeleteMapping("topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void deleteLesson(@PathVariable String lessonId) {
        lessonService.deleteLesson(lessonId);
    }
}
