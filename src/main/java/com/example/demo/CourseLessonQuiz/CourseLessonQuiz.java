package com.example.demo.CourseLessonQuiz;
import com.example.demo.CourseLesson.CourseLesson;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CourseLessonQuiz")
public class CourseLessonQuiz {
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private Long id;
    @Column(nullable = false, unique = true, insertable = false, updatable = false)
    private String lessonId;

    @OneToOne
    @JoinColumn(
        name = "lessonId",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_quiz_lesson")
    )
    private CourseLesson lesson;

    @Column(columnDefinition = "json", nullable = false)
    private String questoes;
    public CourseLessonQuiz() {}
    public CourseLessonQuiz(Long id,String lessonId, String questoes, CourseLesson lesson) {
        this.id = id;
        this.lessonId = lessonId;
        this.questoes = questoes;
        this.lesson = lesson;
    }
    public CourseLessonQuiz(String lessonId, String questoes, CourseLesson lesson) {
        this.lessonId = lessonId;
        this.questoes = questoes;
        this.lesson = lesson;
    }
    public Long getId() {
        return id;
    }
    public String getLessonId() {
        return lessonId;
    }
    public String getQuestoes() {
        return questoes;
    }
    public CourseLesson getLesson() {
        return lesson;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
    public void setQuestoes(String questoes) {
        this.questoes = questoes;
    }
    public void setLesson(CourseLesson lesson) {
        this.lesson = lesson;
    }
    @Override
    public String toString() {
        return "CourseLessonQuiz [id=" + id + ", lessonId=" + lessonId + ", questoes=" + questoes + ", lesson=" + lesson
                + "]";
    }
}
