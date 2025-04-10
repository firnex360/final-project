package practica.logic;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// @Entity
// @Table(name = "urls")
public class ShortURL {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false, unique = true)
    private String shortUrl;

    //@Column(nullable = false)
    private String originalUrl;

    private User user;

    //@Column(nullable = false)
    private int accessCount = 0;

    //@OneToMany(mappedBy = "urlEntry", cascade = CascadeType.ALL)
    private List<URLAccessLog> accessLogs = new ArrayList<>();

    public ShortURL(Long id, String shortUrl, String originalUrl, User user, int accessCount, List<URLAccessLog> accessLogs) {
        this.id = id;
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
        this.user = user;
        this.accessCount = accessCount;
        this.accessLogs = (accessLogs != null) ? accessLogs : new ArrayList<>();
    }

    public ShortURL() {
        this.accessCount = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }  
    
    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public List<URLAccessLog> getAccessLogs() {
        return accessLogs;
    }

    public void setAccessLogs(List<URLAccessLog> accessLogs) {
        this.accessLogs = accessLogs;
    }


}
