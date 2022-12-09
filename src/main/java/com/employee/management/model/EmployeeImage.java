package com.employee.management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medifile")
public class EmployeeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fileName;

    private String fileType;

    private long fileSize;

    @Lob
    private byte[] data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "medication_id", referencedColumnName = "id")
    private Employee medication;

    public EmployeeImage(String fileName, String fileType, long fileSize, byte[] data, Employee medication) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.data = data;
        this.medication = medication;
    }
}
