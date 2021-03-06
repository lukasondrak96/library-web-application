package com.lukasondrak.libraryinformationsystem.features.loan;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class LoanController {

    private LoanService loanService;

    /**
     * Returns new client's loan page
     * @param clientId id of client
     * @param model model
     * @param session http session
     * @return new loan of client page
     */
    @GetMapping("client/{clientId}/loans/new")
    public String newClientsLoanPage(@PathVariable long clientId, Model model, HttpSession session) {
        return loanService.prepareNewClientsLoanPage(clientId, model, session);
    }

    /**
     * Returns all items of loan
     * @param clientId id of client
     * @param loanId id of loan
     * @param session http session
     * @return loans of client page
     */
    @GetMapping("client/{clientId}/loan/{loanId}/return")
    public String returnAllItemsOfLoan(@PathVariable long clientId, @PathVariable long loanId, HttpSession session) {

        return loanService.returnAllItemsOfLoan(clientId, loanId, session);
    }

    /**
     * Returns one item of loan
     * @param clientId id of client
     * @param loanId id of loan
     * @param itemId od of item
     * @param session http session
     * @return loans of client page
     */
    @GetMapping("client/{clientId}/loan/{loanId}/item/{itemId}/return")
    public String returnItemOfLoan(@PathVariable long clientId, @PathVariable long loanId, @PathVariable long itemId, HttpSession session) {

        return loanService.returnItemOfLoan(clientId, loanId, itemId, session);
    }

    /**
     * Extends end date of item of loan by two weeks (14 days)
     * @param clientId id of client
     * @param loanId id of loan
     * @param itemId od of item
     * @param session http session
     * @return loans of client page
     */
    @GetMapping("client/{clientId}/loan/{loanId}/item/{itemId}/extend")
    public String extendItemOfLoanByTwoWeeks(
            @PathVariable long clientId, @PathVariable long loanId, @PathVariable long itemId, HttpSession session
    ) {
        return loanService.extendItemOfLoanByTwoWeeks(clientId, loanId, itemId, session);
    }

    /**
     * Deletes item from client's loan
     * @param clientId id of client
     * @param loanId id of loan
     * @param itemId od of item
     * @param session http session
     * @return loans of client page
     */
    @DeleteMapping("client/{clientId}/loan/{loanId}/item/{itemId}")
    public String deleteItemOfLoanOfClient(
            @PathVariable long clientId, @PathVariable long loanId, @PathVariable long itemId, HttpSession session
    ) {
        return loanService.deleteItemOfLoanOfClient(clientId, loanId, itemId, session);
    }


    /**
     * Deletes client's loan
     * @param clientId id of client
     * @param loanId id of loan
     * @param session http session
     * @return loans of client page
     */
    @DeleteMapping("client/{clientId}/loan/{loanId}")
    public String deleteLoanOfClient(@PathVariable long clientId, @PathVariable long loanId, HttpSession session) {
        return loanService.deleteLoanOfClient(loanId, clientId, session);
    }

    /**
     * Creates new loan to client
     * @param itemIdsToBorrow array of item ids to add to loan (not empty)
     * @param clientId id of client
     * @param session http session
     * @return clients loans page
     */
    @PostMapping("client/{clientId}/loans/newLoan")
    public String addNewLoanToClient( @RequestParam(value = "itemIdsToBorrow" , required = false) long[] itemIdsToBorrow , @PathVariable long clientId,
                                     HttpSession session) {
        return loanService.addNewLoanToClient(itemIdsToBorrow, clientId, session);
    }


}
