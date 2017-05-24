package lmller.github.io.gofkotlin.observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    public interface PropertyChangedListener {
        void onChange(int newValue);
    }

    public static class Property {
        private int value;

        private List<PropertyChangedListener> listeners = new ArrayList<>();

        public void registerListener(PropertyChangedListener listener) {
            listeners.add(listener);
        }

        public void setValue(int value) {
            this.value = value;
            notifyChange();
        }

        private void notifyChange() {
            for (PropertyChangedListener listener : listeners) {
                listener.onChange(value);
            }
        }
    }

    public static void main(String[] args) {
        Property property =  new Property();
        property.registerListener(new PropertyChangedListener() {
            @Override
            public void onChange(int newValue) {
                System.out.println("The new value is " + newValue);
            }
        });

        property.setValue(89);

    }
}
