package com.bookmyshow.Book.My.Show.service;

import com.bookmyshow.Book.My.Show.exceptions.ResourceNotExistException;
import com.bookmyshow.Book.My.Show.exceptions.UnAuthorized;
import com.bookmyshow.Book.My.Show.exceptions.UserDoesNotExistException;
import com.bookmyshow.Book.My.Show.models.*;
import com.bookmyshow.Book.My.Show.repository.ApplicationUserRepository;
import com.bookmyshow.Book.My.Show.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    ShowService showService;

    @Autowired
    MovieService movieService;

    @Autowired
    HallService hallService;

    @Autowired
    MailService mailService;

    @Autowired
    BarCodeGeberationService barCodeGeberationService;
    public Ticket buyTicket(String email, UUID showId){
        // 1. Get user by emailId;
        ApplicationUser user = applicationUserRepository.findByEmail(email);
        // If user is null -> That means no user is existing with this emailID
        if(user == null){
            throw new UserDoesNotExistException(String.format("User with emailId %s does not exist in system.", email));
        }
        // Check user has required access or not -> If user is of type MovieOwner & HallOwner then they don't have access
        if(!user.getType().equals("RegularUser")){
            throw new UnAuthorized(String.format("User with email %s does not have required access", email));
        }
        // validate show with whatever id we are getting in function parameter is existing in our system or not.
        Show show = showService.getShowByShowId(showId);
        if(show == null){
            throw new ResourceNotExistException(String.format("Show with id %s does not exist in our system.", showId));
        }
        // We have to decrease Ticket count for this particular showId as we are buying one ticket.
        showService.updateAvailableTicketCount(show);
        Ticket ticket = new Ticket();
        ticket.setHall(show.getHall());
        ticket.setMovie(show.getMovie());
        ticket.setShow(show);
        ticket.setUser(user);
        ticketRepository.save(ticket);

        Movie movie = movieService.getMovieById(show.getMovie().getId());
        Hall hall = hallService.getHallById(show.getHall().getId());

        // First send ticket details to user
        // UserTicket message
        String userMessage = String.format("Hey %s,\n" +
                "Congratulations!! your ticket got booked on our Accio Booking Application. Below are your ticket details:\n" +
                "1. Movie Name - %s\n" +
                "2. Hall Name - %s\n" +
                "3. Hall Address - %s\n" +
                "4. Date And timings - %s\n" +
                "5. Ticket Price- %d\n" +
                "\n Hope you will enjoy your show, All The Best\n" +
                "Accio Booking Application", user.getName(), movie.getName(), hall.getName(), hall.getAddress(), show.getStartTime().toString(), show.getTicketPrice());

        String userSub = String.format("Congratulations!! %s your ticket got generated !!", user.getName());
        try{
            barCodeGeberationService.generateQR(userMessage);
        }catch (Exception e){
            e.printStackTrace();
        }



        mailService.generateMail(user.getEmail(),userSub, userMessage,"./src/main/resources/static/QRcode.png");

        int totalTickets = movieService.getTotalTicketCount(movie);
        int totalIncome = movieService.getBoxOfficeCollection(movie);

        String movieMessage = String.format("Hii %s\n" +
                "Congratulations!! your ticket got sold\n" +
                "TotalTicketsSold : %d" +
                "TotalIncome : %d", movie.getOwner().getName(), totalTickets, totalIncome);

        String movieSubject = String.format("Congratulations!! %s One more ticket sold", movie.getOwner().getName());
        mailService.generateMail(movie.getOwner().getEmail(), movieSubject, movieMessage);
        return ticket;
    }
}
