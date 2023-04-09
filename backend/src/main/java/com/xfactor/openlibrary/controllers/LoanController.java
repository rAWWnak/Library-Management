package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.xfactor.openlibrary.domain.Loan;
import com.xfactor.openlibrary.repositories.LoanRepository;

@RestController
@RequestMapping("loans")
public class LoanController{
    private LoanRepository loanRepository;

    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping("/saveLoans")
    public Loan saveLoan(@RequestBody Loan Loan){
        if(Loan.getId()==null){
            Loan loan2 = loanRepository.save(Loan);
            return loan2;
        }
        return null;
    }

    @PutMapping("/updateLoan")
    public Loan updateLoan(@RequestBody Loan loan) {
        if (loan.getId() != null) {
            Loan loan2 = loanRepository.save(loan);
            return loan2;
        }
        return null;
    }

    @GetMapping("/getAllLoans")
    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    @GetMapping("/findTotalLoans")
    public Long findTotalLoans(){
        return loanRepository.count();
    }
    
    @GetMapping("findByLoanId/{id}")
    public Loan findById(@PathVariable Long id) {
        Optional<Loan> optionalOfLoan = loanRepository.findById(id);
        if (optionalOfLoan.isPresent()) {
            return optionalOfLoan.get();
        }
        return null;
    }

    @DeleteMapping("deleteLoans/{id}")
    public void deleteLoans(@PathVariable Long id){
        loanRepository.deleteById(id);
    }

    @GetMapping("findBycheckoutdate/{checkoutdate}")
    public List<Loan> findBycheckoutDate(@PathVariable String checkoutDate) {
        List<Loan> loans = loanRepository.findByCheckoutDate(checkoutDate);
        return loans;
    }
}