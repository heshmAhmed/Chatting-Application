package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IMessageService;
import gov.iti.jets.server.services.util.HashingFactory;
import gov.iti.jets.server.services.util.ServerUtil;

import java.rmi.RemoteException;
import java.util.Optional;

public class MessageServiceImpl implements IMessageService {

    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final ServerUtil serverUtil = ServerUtil.getInstance();
    private final IUserRepository userRepository = repoFactory.getUserRepo();



    @Override
    public void sendMessage(MessageDTO messageDTO) {

        try {
            serverUtil.sendMessage(messageDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
