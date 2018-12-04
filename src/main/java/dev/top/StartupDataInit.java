package dev.top;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.VersionRepo;
import dev.top.repos.CollegueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;
    
    @Autowired
    CollegueRepo collegueRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        if(this.versionRepo.count() <= 0) {
            this.versionRepo.save(new Version("v1"));
            this.versionRepo.save(new Version("v2"));
            this.versionRepo.save(new Version("v3"));
            this.versionRepo.save(new Version("v4"));
        }
        
        if(this.collegueRepo.count() <= 0) {
        	this.collegueRepo.save(new Collegue("Patrick","https://media.giphy.com/media/eHpWHuEUxHIre/giphy.gif"));
        	this.collegueRepo.save(new Collegue("Bob","https://media.giphy.com/media/DROP5YnPcJLLG/giphy.gif"));
        	this.collegueRepo.save(new Collegue("Gary","https://media.giphy.com/media/9pnP2yxqjheFO/giphy.gif"));
        	this.collegueRepo.save(new Collegue("Krabs","https://media.giphy.com/media/gXhBZfzijya76/giphy.gif"));
        	this.collegueRepo.save(new Collegue("Sandy","https://media.giphy.com/media/l1Ku53fLq0C2KYWsg/giphy.gif"));
        	this.collegueRepo.save(new Collegue("Plankton","https://media.giphy.com/media/3ohzAiVqeYVSaqoP6w/giphy.gif"));
        	this.collegueRepo.save(new Collegue("Carlo","https://media.giphy.com/media/3oKHWuRz1wzaAoygZa/giphy.gif"));
        	this.collegueRepo.save(new Collegue("Nian","https://media.giphy.com/media/BcZZaMtMBmakw/giphy.gif"));
        	this.collegueRepo.save(new Collegue("Puff","https://media.giphy.com/media/3oKHWoYA631FfBJPuE/giphy.gif"));
        }

    }
}
