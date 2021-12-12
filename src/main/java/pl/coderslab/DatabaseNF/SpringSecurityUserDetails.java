package pl.coderslab.DatabaseNF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.DatabaseNF.entity.Therapist;
import pl.coderslab.DatabaseNF.repository.TherapistRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

public class SpringSecurityUserDetails implements UserDetailsService {

    private TherapistRepository therapistRepository;

    @Autowired
    public void setTherapistRepository(TherapistRepository therapistRepository) {
        this.therapistRepository = therapistRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Therapist therapist = therapistRepository.findByLogin(login);
        if (therapist == null) {
            throw new UsernameNotFoundException(login);
        }
        return new User(therapist.getLogin(), therapist.getPassword(), Collections.emptyList());
    }
}
