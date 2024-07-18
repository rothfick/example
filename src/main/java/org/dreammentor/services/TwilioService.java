package org.dreammentor.services;

import com.twilio.Twilio;
import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.VideoGrant;
import com.twilio.rest.video.v1.Room;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.api_key_sid}")
    private String apiKeySid;

    @Value("${twilio.api_key_secret}")
    private String apiKeySecret;

    @PostConstruct
    private void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public Room createRoom(String roomName) {
        return Room.creator()
                .setUniqueName(roomName)
                .setType(Room.RoomType.GROUP)
                .setStatusCallback("http://example.com/callbacks")
                .create();
    }

    public Room getRoom(String roomName) {
        return Room.fetcher(roomName).fetch();
    }

    public String generateToken(String identity, String roomName) {
        VideoGrant grant = new VideoGrant().setRoom(roomName);
        AccessToken token = new AccessToken.Builder(accountSid, apiKeySid, apiKeySecret)
                .identity(identity)
                .grant(grant)
                .build();
        return token.toJwt();
    }
}
