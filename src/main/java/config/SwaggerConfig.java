package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(this.apiInfo())
                .host("localhost:8080")
                .select()
                .apis(RequestHandlerSelectors.basePackage("uk.gov.dwp.bps.cm"))
                .paths(regex("/.*"))
                .build();

    }

    private ApiInfo apiInfo() {
        final Contact contact = new Contact("BSP Team",
                "https://gitlab.itsshared.net/bereavement-support-payment/ClaimManagementApplication",
                "bspdigital@dwp.gsi.gov.uk");

        return new ApiInfoBuilder()
                .title("BSP Claim Capture")
                .description(
                        "A claim capture component for BSP Claims.")
                .termsOfServiceUrl("https://gitlab.itsshared.net/ClaimManagementApplication/tos")
                .contact(contact)
                .license("ISC License (ISC)")
                .licenseUrl("https://choosealicense.com/licenses/isc/")
                .version("0.0.1")
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return new UiConfiguration(null);
    }

}