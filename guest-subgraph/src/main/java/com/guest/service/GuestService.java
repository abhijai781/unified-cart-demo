package com.guest.service;

import com.guest.model.Guest;
import com.guest.model.Sailing;
import com.guest.model.SailingStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {
    
    private List<Guest> guests = new ArrayList<>();
    
    public GuestService() {
        guests.add(new Guest("A001", "user1", "user1@example.com", Arrays.asList(
            new Sailing("SHIP1", "2023-10-01", SailingStatus.UPCOMING, false),
            new Sailing("ship1", "31-01-2026", SailingStatus.ACTIVE, true),
                new Sailing("SHIP3", "2024-10-05", SailingStatus.COMPLETED, true)
        )));
        guests.add(new Guest("A002", "user2", "user2@example.com", Arrays.asList(
            new Sailing("SHIP3", "2023-09-15", SailingStatus.COMPLETED, false),
            new Sailing("SHIP2", "2023-10-05", SailingStatus.CANCELLED, true)
        )));
        guests.add(new Guest("A003", "user3", "user3@example.com", Arrays.asList(
            new Sailing("SHIP4", "2023-11-01", SailingStatus.UPCOMING, false)
        )));
        guests.add(new Guest("A004", "user4", "user4@example.com", Arrays.asList(
            new Sailing("SHIP5", "2023-10-10", SailingStatus.ACTIVE, true),
            new Sailing("SHIP6", "2023-09-20", SailingStatus.COMPLETED, false)
        )));
        guests.add(new Guest("A005", "user5", "user5@example.com", Arrays.asList(
            new Sailing("SHIP7", "2023-12-01", SailingStatus.UPCOMING, false)
        )));
    }
    
    public Guest getGuestByAccountId(String accountId) {
        return guests.stream()
                .filter(guest -> guest.getAccountId().equals(accountId))
                .findFirst()
                .orElse(null);
    }
    
    public List<Sailing> fetchSailings(String accountId, List<SailingStatus> status, Integer first) {
        
        Guest guest = getGuestByAccountId(accountId);
        
        List<Sailing> allSailings = null;
        // Filter by status if provided
        if (status != null && !status.isEmpty() && hasSailings(guest)) {
            allSailings = guest.getSailings().stream()
                    .filter(s -> status.contains(s.getStatus()))
                    .collect(Collectors.toList());
            if (first != null && first > 0) {
                allSailings = allSailings.stream().limit(first).collect(Collectors.toList());
            }
        }
        // Limit by first if provided
       
        return allSailings;
    }
    
    public boolean hasSailings(Guest guest) {
        return guest != null && guest.getSailings() != null && !guest.getSailings().isEmpty();
    }
}
