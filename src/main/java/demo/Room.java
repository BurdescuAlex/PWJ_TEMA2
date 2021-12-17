package demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long roomNo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    @JsonBackReference
    private Set<Track> tracks;

    public Room() {}

    public Room(long roomNo) { this.roomNo = roomNo; }

    public long getId() { return id; }

    public long roomNo() { return roomNo; }

    public Set<Track> getTracks() { return tracks; }

    public void update(int roomNo) { this.roomNo=roomNo; }
}