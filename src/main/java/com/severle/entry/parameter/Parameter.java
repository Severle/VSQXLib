package com.severle.entry.parameter;

public enum Parameter {
    BRE {
        @Override
        public String getType() {
            return "B";
        }
    },
    BRI {
        @Override
        public String getType() {
            return "R";
        }
    },
    CLE {
        @Override
        public String getType() {
            return "C";
        }
    },
    DYN {
        @Override
        public String getType() {
            return "D";
        }
    },
    GEN {
        @Override
        public String getType() {
            return "G";
        }
    },
    GWL {
        @Override
        public String getType() {
            return "W";
        }
    },
    PBS {
        @Override
        public String getType() {
            return "S";
        }
    },
    PIT {
        @Override
        public String getType() {
            return "P";
        }
    },
    POR {
        @Override
        public String getType() {
            return "T";
        }
    },
    XSY {
        @Override
        public String getType() {
            return "X";
        }
    };

    public abstract String getType();
}
