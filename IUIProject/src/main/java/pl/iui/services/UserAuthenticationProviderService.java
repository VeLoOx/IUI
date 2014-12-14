package pl.iui.services;

import pl.iui.domain.user.UserEntity;

/**
 * Provides processing service to set user authentication session
 *
 */
public interface UserAuthenticationProviderService {

        /**
         * Process user authentication
         *
         * @param user
         * @return
         */
        boolean processUserAuthentication(UserEntity user);
}
