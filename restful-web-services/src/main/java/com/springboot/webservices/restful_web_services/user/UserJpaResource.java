package com.springboot.webservices.restful_web_services.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.webservices.restful_web_services.jpa.PostRepository;
import com.springboot.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository userRepository;

	private PostRepository postRepository;

	public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	// GET /users

	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{userId}")
	public EntityModel<User> findOne(@PathVariable Integer userId) {
		Optional<User> user = userRepository.findById(userId);

		if (user.isEmpty()) {
			throw new UserNotFoundException("id : " + userId);
		}

		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@DeleteMapping("/jpa/users/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userRepository.deleteById(userId);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUsers(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("id : " + id);
		}

		return user.get().getPosts();
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> retrievePostsForUsers(@PathVariable Integer id, @Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("id : " + id);
		}

		post.setUser(user.get());

		Post savedPosts = postRepository.save(post);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPosts.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}