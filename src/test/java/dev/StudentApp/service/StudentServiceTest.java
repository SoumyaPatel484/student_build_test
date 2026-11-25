package dev.StudentApp.service;

import dev.StudentApp.entity.Student;
import dev.StudentApp.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void saveStudentReturnsSavedStudent() {
        Student student = new Student();
        when(studentRepository.save(student)).thenReturn(student);

        Student savedStudent = studentService.saveStudent(student);

        assertSame(student, savedStudent);
        verify(studentRepository).save(student);
    }

    @Test
    void getAllStudentsReturnsRepositoryResults() {
        List<Student> students = List.of(new Student(), new Student());
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();

        assertSame(students, result);
        verify(studentRepository).findAll();
    }

    @Test
    void deleteStudentDeletesById() {
        Long studentId = 1L;

        studentService.deleteStudent(studentId);

        verify(studentRepository).deleteById(studentId);
    }
}
