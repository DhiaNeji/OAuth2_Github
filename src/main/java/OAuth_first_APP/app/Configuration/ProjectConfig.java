package OAuth_first_APP.app.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter{

	@Bean
	 public ClientRegistrationRepository clientRepository() {
	 ClientRegistration c = clientRegistration();
	 return new InMemoryClientRegistrationRepository(c);
	 }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.oauth2Login();
		System.out.println("hello");
		http.authorizeRequests().anyRequest().authenticated();
	}
	
	private ClientRegistration clientRegistration()
	{
		return CommonOAuth2Provider.GITHUB.getBuilder("github")
				.clientId("XXXXX") // the ClientID received by Github API after submitting the form
				.clientSecret("XXXX").build(); // the ClientSecret received by Github API after submitting the form
	}
}
