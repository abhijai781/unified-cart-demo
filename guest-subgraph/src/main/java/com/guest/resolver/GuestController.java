package com.guest.resolver;


import com.guest.model.Guest;
import com.guest.model.Sailing;
import com.common.model.SailingStatus;
import com.guest.service.GuestService;
import org.springframework.graphql.data.federation.EntityMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @QueryMapping
    public Guest guest(@Argument String accountId) {
        return guestService.getGuestByAccountId(accountId);
    }

    @QueryMapping
    public List<Sailing> sailings(@Argument String accountId, @Argument List<SailingStatus> status, @Argument Integer first) {
        return guestService.fetchSailings(accountId,status, first);
        // Mock implementation
        
    }

    @SchemaMapping(typeName = "Guest", field = "sailings")
    public List<Sailing> getSailings(Guest guest, @Argument List<SailingStatus> status, @Argument Integer first) {
        List<Sailing> allSailings = guest.getSailings();
        if (status != null && !status.isEmpty()) {
            allSailings = allSailings.stream().filter(s -> status.contains(s.getStatus())).toList();
        }
        if (first != null) {
            allSailings = allSailings.stream().limit(first).toList();
        }
        return allSailings;
    }

    @EntityMapping
    public Guest guest(Map<String, Object> key) {
        String accountId = (String) key.get("accountId");
        return guest(accountId);
    }

    @EntityMapping
    public Sailing sailing(Map<String, Object> key) {
        String shipCode = (String) key.get("shipCode");
        String sailDate = (String) key.get("sailDate");
        // Mock implementation
        return new Sailing(shipCode, sailDate, SailingStatus.UPCOMING, false);
    }
}
