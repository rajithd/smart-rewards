package com.cmr.api.service.impl;

import com.cmr.api.dao.CampaignRepository;
import com.cmr.api.dao.UserAccountRepository;
import com.cmr.api.dao.config.SecurityConfig;
import com.cmr.api.service.CampaignManagementService;
import com.cmr.beans.campaign.Campaign;
import com.cmr.beans.exeception.APIException;
import com.cmr.beans.user.UserAccount;
import com.cmr.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : rajith
 */
@Service
public class CampaignManagementServiceImpl implements CampaignManagementService {

    private final static Logger logger = LoggerFactory.getLogger(CampaignManagementServiceImpl.class);

    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public void saveUser(UserAccount userAccount) throws APIException {
        if (userAccount == null || userAccount.getUsername() == null ||
                userAccount.getPassword() == null || userAccount.getUserType() == null) {
            logger.error("UserAccount details null. Throwing API Exception");
            throw new APIException("1000", "Invalid user account details");
        }
        userAccount.setPassword(hashedPassword(userAccount.getPassword()));
        String userType = userAccount.getUserType();
        logger.info("Found user type as  : [{}]", userType);
        if (Constants.USER_TYPE_ADMIN.equals(userType)) {
            userAccount.setRoles(securityConfig.getAdminRoles());
        } else {
            userAccount.setRoles(securityConfig.getManagerRoles());
        }
        logger.info("Saving user : [{}]", userAccount.getUsername());
        userAccountRepository.save(userAccount);

    }

    @Override
    public void saveCampaign(Campaign campaign) throws APIException {
        logger.info("Trying to save campaign");
        campaignRepository.save(campaign);
        logger.info("Saved campaign successfully");
    }

    private String hashedPassword(String password){
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(password,null);
    }
}
