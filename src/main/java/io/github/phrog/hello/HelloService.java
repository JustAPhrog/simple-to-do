package io.github.phrog.hello;

import io.github.phrog.lang.Lang;
import io.github.phrog.lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello","en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private LangRepository repository;

    HelloService(LangRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name, Integer langId){
        langId = Optional.ofNullable(langId).map(Integer::valueOf).orElse(FALLBACK_LANG.getId());
        var welcomeMessage = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMessage();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMessage + " " + nameToWelcome + "!";
    }
}
