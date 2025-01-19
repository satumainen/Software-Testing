class Alarm:
    class State:
        DISARMED_OPEN = 'DISARMED_OPEN'
        DISARMED_CLOSED = 'DISARMED_CLOSED'
        ARMED_CLOSED = 'ARMED_CLOSED'
        ARMED_OPEN = 'ARMED_OPEN'

    ARM_LIGHTS = 1
    DISARM_LIGHTS = 2
    ALARM_LIGHTS = 27
    NO_LIGHTS = 0
    ERROR = -1

    def __init__(self):
        self.current_state = self.State.DISARMED_OPEN
        self.armed = False

    def _set_state(self, new_state):
        print("{}-->{}".format(self.current_state, new_state))
        self.current_state = new_state

    def reset(self):
        self._set_state(self.State.DISARMED_OPEN)
        return self.NO_LIGHTS

    def arm(self):
        if self.current_state == self.State.DISARMED_OPEN:
            self._set_state(self.State.ARMED_OPEN)
            return self.NO_LIGHTS

        if self.current_state == self.State.ARMED_OPEN:
            return self.NO_LIGHTS

        if self.current_state == self.State.DISARMED_CLOSED:
            self._set_state(self.State.DISARMED_CLOSED)
            return self.ARM_LIGHTS

        if self.current_state == self.State.ARMED_CLOSED:
            return self.ARM_LIGHTS

        return self.ERROR

    def disarm(self):
        if self.current_state == self.State.DISARMED_CLOSED:
            return self.DISARM_LIGHTS

        if self.current_state == self.State.DISARMED_OPEN:
            return self.DISARM_LIGHTS

        if self.current_state == self.State.ARMED_CLOSED:
            self._set_state(self.State.DISARMED_CLOSED)
            return self.DISARM_LIGHTS

        if self.current_state == self.State.ARMED_OPEN:
            self._set_state(self.State.DISARMED_OPEN)
            return self.DISARM_LIGHTS

        return self.ERROR

    def open_doors(self):
        if self.current_state == self.State.DISARMED_CLOSED:
            self._set_state(self.State.DISARMED_OPEN)
            return self.NO_LIGHTS

        if self.current_state == self.State.ARMED_CLOSED:
            self._set_state(self.State.ARMED_OPEN)
            return self.ALARM_LIGHTS

        return self.ERROR

    def close_doors(self):

        if self.current_state == self.State.DISARMED_OPEN:
            self._set_state(self.State.DISARMED_CLOSED)
            return self.NO_LIGHTS

        if self.current_state == self.State.ARMED_OPEN:
            self._set_state(self.State.ARMED_CLOSED)
            return self.ARM_LIGHTS
        return self.ERROR


if __name__ == "__main__":
    alarm = Alarm()
    print(alarm.arm(), "arm")
    print(alarm.close_doors(), "close")
    print(alarm.open_doors(), "open")
    print(alarm.close_doors(), "close")
    print(alarm.open_doors(), "open")
    print(alarm.disarm(), "disarm")
    print(alarm.close_doors(), "close")
    print(alarm.arm(), "arm")
    print(alarm.open_doors(), "open")
    print(alarm.disarm(), "disarm")
    print(alarm.close_doors(), "close")
    print(alarm.arm(), "arm")
    print(alarm.disarm(), "disarm")
    print(alarm.disarm(), "disarm")
