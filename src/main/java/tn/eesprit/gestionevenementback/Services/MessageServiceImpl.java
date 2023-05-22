package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Message;
import tn.eesprit.gestionevenementback.Repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements IMessageService{
    private final MessageRepository MessageRepo;
    @Override
    public List<Message> retrieveAllMessages(){return MessageRepo.findAll();}
    @Override
    public Message addOrUpdateMessage(Message message){return MessageRepo.save(message);}
    @Override
    public Message retrieveMessage(Integer id){return MessageRepo.findById(id).orElse(null);}
    @Override
    public void removeMessage(Integer id){MessageRepo.deleteById(id);}

}
