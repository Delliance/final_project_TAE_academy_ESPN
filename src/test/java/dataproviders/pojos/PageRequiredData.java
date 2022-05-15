package dataproviders.pojos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class PageRequiredData {

    private User user;

    private String webPageName;

    private String iFrameLogoName;

    private String singUpTitle;

}
