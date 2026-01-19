package com.roomservice.service;

import com.roomservice.model.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Service
public class RoomServiceService {

    public RoomServiceCart getRoomServiceCart(String accountId, String shipCode, String sailDate, Integer itemCount, Integer subTotalMinor) {
        // Sample data
        RoomServiceCartItem item1 = new RoomServiceCartItem("item1", "Burger", 2, 1000, 2000, "image1.jpg", "No onions", Instant.now());
        RoomServiceCartItem item2 = new RoomServiceCartItem("item2", "Fries", 1, 500, 500, "image2.jpg", null, Instant.now());
        List<RoomServiceCartItem> items = Arrays.asList(item1, item2);

        CartAvailability availability = new CartAvailability(true, null);

        return new RoomServiceCart("cart123", accountId, shipCode, sailDate, "101", UnifiedCartType.ROOM_SERVICE, itemCount, "menu1", items, subTotalMinor, "USD", false, "ASAP", availability);
    }
    
    public RoomServiceCart getRoomServiceCartForSailing(String shipCode, String sailDate, String accountId) {
        // Sample data based on shipCode and sailDate

        RoomServiceCartItem item = new RoomServiceCartItem("item1", "Pizza", 1, 1500,
                1500, "pizza.jpg", null, Instant.now());
        CartAvailability availability = new CartAvailability(true, null);
        return new RoomServiceCart("cart456", accountId, shipCode, sailDate, "102", UnifiedCartType.ROOM_SERVICE,
                1, "menu2", Arrays.asList(item), 1500, "USD", true, "Dinner", availability);
    }

    public UnifiedCartSummary getUnifiedCartSummary(String accountId) {
        // Sample data
        CartSummary cart1 = new CartSummary(UnifiedCartType.ROOM_SERVICE, 3, 2500, new CartAvailability(true, null));
        SailingCartSummary sailing1 = new SailingCartSummary("SHIP1", "2023-10-01", Arrays.asList(cart1));

        CartSummary cart2 = new CartSummary(UnifiedCartType.COMMERCE, 1, 1500, new CartAvailability(false, "Out of stock"));
        SailingCartSummary sailing2 = new SailingCartSummary("SHIP2", "2023-10-05", Arrays.asList(cart2));

        List<SailingCartSummary> sailings = Arrays.asList(sailing1, sailing2);

        return new UnifiedCartSummary(4, 4000, "USD", sailings);
    }

   

    public RoomServiceCart getRoomServiceCartById(String cartId) {
        // Mock data based on cartId
        if ("cart123".equals(cartId)) {
            RoomServiceCartItem item1 = new RoomServiceCartItem("item1", "Burger", 2, 1000, 2000, "image1.jpg", "No onions", Instant.now());
            RoomServiceCartItem item2 = new RoomServiceCartItem("item2", "Fries", 1, 500, 500, "image2.jpg", null, Instant.now());
            List<RoomServiceCartItem> items = Arrays.asList(item1, item2);
            CartAvailability availability = new CartAvailability(true, null);
            return new RoomServiceCart(cartId, "A001", "SHIP1", "2023-10-01", "101", UnifiedCartType.ROOM_SERVICE, 3, "menu1", items, 2500, "USD", false, "ASAP", availability);
        }
        // Default mock
        return new RoomServiceCart(cartId, "A001", "SHIP1", "2023-10-01", "101", UnifiedCartType.ROOM_SERVICE, 1, "menu1", Arrays.asList(), 0, "USD", false, "ASAP", new CartAvailability(true, null));
    }
}
