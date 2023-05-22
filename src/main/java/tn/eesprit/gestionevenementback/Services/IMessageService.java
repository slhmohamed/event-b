package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Message;

import java.util.List;

public interface IMessageService {
    List<Message> retrieveAllMessages();
    Message addOrUpdateMessage(Message Message);
    Message retrieveMessage(Integer id);
    void removeMessage(Integer id);
}

