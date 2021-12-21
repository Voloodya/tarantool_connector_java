package connector;

import java.util.*;
import org.tarantool.TarantoolClient;
import org.tarantool.TarantoolClientConfig;
import org.tarantool.TarantoolClientImpl;
import org.tarantool.Iterator;

public class Connector {
  public static void main(String[] args) {

    TarantoolClientConfig config = new TarantoolClientConfig();
    config.username = "guest";

    TarantoolClient client = new TarantoolClientImpl("127.0.0.1:3301", config);

    // Добавление таплов
    client.syncOps().insert("test", Arrays.asList(5,"5"));
    client.syncOps().insert("test", Arrays.asList(6,"6"));
    client.syncOps().insert("test", Arrays.asList(7,"7"));

    List<?> result = client.syncOps().select("test", "primary", Collections.singletonList(3), 0, 1, Iterator.EQ); // Чтение записи с id 3

    client.syncOps().insert("test", Arrays.asList(101, "101")); // Добавление тапла

    System.out.println(result);
  }
}