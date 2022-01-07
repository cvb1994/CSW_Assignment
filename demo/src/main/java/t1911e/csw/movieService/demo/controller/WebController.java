package t1911e.csw.movieService.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import t1911e.csw.movieService.demo.config.JwtTokenProvider;
import t1911e.csw.movieService.demo.dto.LoginRequest;
import t1911e.csw.movieService.demo.dto.MovieDto;
import t1911e.csw.movieService.demo.dto.ResponseDto;
import t1911e.csw.movieService.demo.entity.User;
import t1911e.csw.movieService.demo.entity.UserPrincipal;
import t1911e.csw.movieService.demo.service.MovieService;

@RestController
@RequestMapping("/api")
public class WebController {

	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private MovieService movieSer;
    
    @PostMapping("/public")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
    	System.out.println("Da vao day");
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));

            SecurityContextHolder.getContext().setAuthentication(authenticate);
            
            String jwt = tokenProvider.generateToken((UserPrincipal) authenticate.getPrincipal());

            return ResponseEntity.ok(jwt);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @GetMapping("/random")
    public String randomStuff(){
        return new String("JWT Hợp lệ mới có thể thấy được message này");
    }
    
    @GetMapping("/list")
    public ResponseEntity<?> list(){
    	List<MovieDto> trending = movieSer.listRandom();
    	List<MovieDto> top = movieSer.listRandom();
    	ResponseDto res = new ResponseDto();
    	res.setMesssage("Success");
		res.setTrending(trending);
		res.setTop(top);
        return ResponseEntity.ok(res);
    }
    
    @PostMapping(value = "/saveMovie", consumes = {"multipart/form-data"})
    public ResponseEntity<?> saveMovie(@ModelAttribute("movieDto") MovieDto movieDto) throws IOException{
    	System.out.println("da vao day");
    	movieSer.save(movieDto);
		return null;
    }
}
