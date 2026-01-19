package com.commercecart.resolver;

import com.commercecart.model.CommerceCart;
import com.commercecart.model.Sailing;
import com.commercecart.model.SailingStatus;
import com.commercecart.model.UnifiedCartSummary;
import com.commercecart.service.CommerceCartService;
import org.springframework.graphql.data.federation.EntityMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class CommerceCartController {

    private final CommerceCartService commerceService;

    public CommerceCartController(CommerceCartService commerceService) {
        this.commerceService = commerceService;
    }

    @QueryMapping
    public CommerceCart commerceCart(@Argument String accountId, @Argument String shipCode, @Argument String sailDate, @Argument Integer itemCount, @Argument Integer subTotalMinor) {
        return commerceService.getCommerceCart(accountId, shipCode, sailDate, itemCount, subTotalMinor);
    }
    
    @SchemaMapping(typeName = "Sailing", field = "commerceCart")
    public CommerceCart getCommerceCart(@Argument String accountId, Sailing sailing) {
        return commerceService.getCommerceCartForSailing(sailing.getShipCode(), sailing.getSailDate(), accountId);
    }
    
    @EntityMapping
    public Sailing sailing(Map<String, Object> key) {
        String shipCode = (String) key.get("shipCode");
        String sailDate = (String) key.get("sailDate");
        return new Sailing(shipCode, sailDate, SailingStatus.UPCOMING, false);
    }

    @EntityMapping
    public CommerceCart commerceCart(Map<String, Object> key) {
        String cartId = (String) key.get("cartId");
        return commerceService.getCommerceCartById(cartId);
    }

    @QueryMapping
    public UnifiedCartSummary unifiedCartSummary(@Argument String accountId) {
        return commerceService.getUnifiedCartSummary(accountId);
    }

    
}
