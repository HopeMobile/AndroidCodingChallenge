package hope.david.AndroidCodingChallenge;

import javax.inject.Singleton;

import dagger.Component;
import hope.david.AndroidCodingChallenge.Book.BookActivity;
import hope.david.AndroidCodingChallenge.Network.ApiModule;

@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {
     // Component to be used as home for all modules

     void inject(BookActivity bookActivity);
}
