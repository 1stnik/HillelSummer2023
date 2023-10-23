package com.exchange.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class UserWalletsDto {
    private UserDto userDto;
    List<WalletDto> userWallets;
}
