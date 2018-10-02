package models;

public interface PlayerEventsListener {
    void onManualCombinationRequest();
    void onCombinationChoosen(Color[] c);
}
