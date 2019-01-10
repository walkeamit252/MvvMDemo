package in.com.mvvmdemo.login;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel  {

    private UserModelInteractor user;
    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    private MutableLiveData<String> result = new MutableLiveData<>();
    public MutableLiveData<String> toastMessage = new MutableLiveData<>();

    public void setToastMessage(String result) {
        this.toastMessage.setValue(result);
    }

    public LiveData<String> getToastMessage() {
        return toastMessage;
    }

    public LoginViewModel() {
        user = new UserModelInteractor("", "");
    }

    public void afterEmailTextChanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        if (user.isInputDataValid())
        {
            setToastMessage(successMessage);
            int statusCode=user.fetchMoviesList();
            setResult(statusCode+"");
        }
        else{
        setToastMessage(errorMessage);
        }
    }

    public void setResult(String result) {
        this.result.setValue(result);
    }

    public LiveData<String> getResult() {
        return result;
    }
}