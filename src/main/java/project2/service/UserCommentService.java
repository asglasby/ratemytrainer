package project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project2.model.UserComments;
import project2.repository.UserCommentsImp;

@Service
public class UserCommentService implements ModelService<UserComments>{

	@Autowired
	private UserCommentsImp userCommentsDao;
	
	
	@Override
	public List<UserComments> getAll() {		
		return userCommentsDao.getAllUserComments();
	}

	
	@Override
	public UserComments getById(int id) {
		return userCommentsDao.getCommentInfoById(id);
	}

	
	public Integer save(UserComments userComments) {
		return userCommentsDao.save(userComments);
	}
	
	
	@Override
	public void saveOrUpdate(UserComments userComments) {
		userCommentsDao.saveOrUpdate(userComments);
	}
	
	
	public List<UserComments> getAllCommentsOfTrainer(String username) {
	  return userCommentsDao.getAllCommentsOfTrainer(username);
	}

	
}
