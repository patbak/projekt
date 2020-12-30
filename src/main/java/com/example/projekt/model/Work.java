package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roboty")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roboty")
    private int workId;

    @Column(name = "nazwa_roboty")
    private String workName;

    @OneToMany(
            mappedBy = "work",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<WorkDone> worksDone;

    public List<WorkDone> getWorksDone() {
        return worksDone;
    }

    public void setWorksDone(List<WorkDone> worksDone) {
        this.worksDone = worksDone;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }
}
