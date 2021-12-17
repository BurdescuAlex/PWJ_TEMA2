package demo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name="speaker_id", referencedColumnName = "id")
    private Person speaker;

    @ManyToMany(mappedBy = "tracks")
    private Set<Person> attendees;

    public Track() {

    }
    public Track(String title, String description, Person speaker, Room room) {
        this.title = title;
        this.description = description;
        this.speaker = speaker;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Person getSpeaker() {
        return speaker;
    }

    public Set<Person> getAttendees() {
        return attendees;
    }

    public Room getRoom() { return room; }


    public void update (Track track) {
        this.title = track.getTitle();
        this.description = track.getDescription();
        this.speaker = track.getSpeaker();
        this.room = track.room;
    }
}
