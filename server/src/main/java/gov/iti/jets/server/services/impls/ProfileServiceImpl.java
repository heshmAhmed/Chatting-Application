package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IProfileService;
import gov.iti.jets.server.services.mapper.UserEntityMapper;

public class ProfileServiceImpl implements IProfileService {
    private final IUserRepository userRepository = RepoFactory.getInstance().getUserRepo();
    private final static ProfileServiceImpl profileService = new ProfileServiceImpl();
    private ProfileServiceImpl() {}

    public static ProfileServiceImpl getInstance() {
        return profileService;
    }

    @Override
    public boolean updateProfile(UserDTO userDTO) {
        return userRepository.updateUser(UserEntityMapper.INSTANCE.userDTOToEntity(userDTO));
    }
}
