package com.utshab.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course") // for fetch type LAZY need to exclude the course from the to string
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;
    // LAZY fetch type only fetch this class data
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // EAGER fetch type will also load the course data
    @JoinColumn(name = "course_id", // name of the column that will generate in database
            referencedColumnName = "courseId" // referencing courseId as foreign key from Course class
    )
    private Course course;
}
