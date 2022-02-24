package gov.iti.jets.server.repository.interfaces;

import gov.iti.jets.server.repository.entity.InvitationEntity;

import java.util.List;

public interface IInvitationRepository {
    boolean alreadyInvitedMe(String receiverPhoneNumber,String senderPhoneNumber );
    boolean deleteInvitation(String receiverPhoneNumber,String senderPhoneNumber );
    boolean addInvitation(String receiverPhoneNumber, String senderPhoneNumber,long date);
    List<InvitationEntity> getAllUserInvitations(String userPhoneNumber);


}
