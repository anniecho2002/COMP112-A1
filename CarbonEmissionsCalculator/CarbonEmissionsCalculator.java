/* Code for COMP-102-112 - 2021T1, Assignment 1
 * Name: Annie Cho
 * Username: choanni
 * ID: 300575457
 */

import ecs100.*;

/** Program for calculating carbon emissions */

public class CarbonEmissionsCalculator{

    public static final double EMISSION_FACTOR_POWER = 0.0977;// emissions factor of electricity per kWh
    public static final double EMISSION_FACTOR_WASTE = 0.299;// emissions factor of food waste per kg
    public static final double ANNUAL_AVERAGE_POWER_EMISSION_NZ = 266.5;//Annual average carbon emissions in NZ (kg) from electricity use
    public static final double ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ = 18; //Annual average carbon emissions in NZ (kg) from food waste
    public static final double EMISSION_FACTOR_CAR = 0.265;
    public static final double EMISSION_FACTOR_ELECTRIC_CAR = 0.026;
    public static final double EMISSION_FACTOR_BUS = 0.136; //national average for bus
    public static final double EMISSION_FACTOR_ELECTRIC_BUS = 0.013;
    public static final double EMISSION_FACTOR_TRAIN = 0.014;
    public static final double EMISSION_FACTOR_ELECTRIC_TRAIN = 0.009;

    public void calculateEmissions(){
        double power_input = UI.askDouble("What is your monthly consumption of electricity (in kwh)?");
        double waste_input = UI.askDouble("What is your weekly food waste (in kg)?");
        
        UI.printf("Your monthly power emissions is: %5.2f%n", power_input*EMISSION_FACTOR_POWER);
        UI.printf("Your weekly food waste emissions is: %5.2f%n", waste_input*EMISSION_FACTOR_WASTE);
        
        double power_daily = ((power_input*EMISSION_FACTOR_POWER)*12)/365;
        double waste_daily = (waste_input*EMISSION_FACTOR_WASTE)/7;
        double average = power_daily+waste_daily;
        UI.printf("Your average daily emissions is: %5.2f%n", average);
        UI.println();
        
        double hh_power_input = UI.askDouble("What is the monthly consumption of electricity of the household (in kwh)?");
        double hh_waste_input = UI.askDouble("What is the weekly food waste of the household (in kg)?");
        double hh_power_emissions = hh_power_input*EMISSION_FACTOR_POWER;
        double hh_waste_emissions = hh_waste_input*EMISSION_FACTOR_WASTE;
        UI.printf("Your household's monthly power emissions is: %5.2f%n", hh_power_emissions);
        UI.printf("Your household's weekly waste emissions is: %5.2f%n", hh_waste_emissions);
        
        double hh_power_emissions_daily = (hh_power_emissions*12)/365;
        double hh_waste_emissions_daily = hh_waste_emissions/7;
        double hh_annual_average = (hh_power_emissions*12) + (hh_waste_emissions*52);
        double hh_average = hh_power_emissions_daily+hh_waste_emissions_daily;
        UI.printf("Your household's average daily waste emissions is: %5.2f%n", hh_average);
        double hh_members = UI.askDouble("How many members are in your household?");
        
        double nz_annual_consumption = (ANNUAL_AVERAGE_POWER_EMISSION_NZ*hh_members)+(ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ*hh_members);
        
        UI.printf("As a %% of the NZ average, your emissions are: %5.1f%n", (hh_annual_average/nz_annual_consumption)*100);
        UI.println();
        
        double car_input = UI.askDouble("How many km do you typically travel in a car per day?");
        double bus_input = UI.askDouble("How many km do you typically travel in a bus per day?");
        double train_input = UI.askDouble("How many km do you typically travel in a train per day?");
        UI.println();
        
        double car_emissions = car_input*EMISSION_FACTOR_CAR;
        double bus_emissions = bus_input*EMISSION_FACTOR_BUS;
        double train_emissions = train_input*EMISSION_FACTOR_TRAIN;
        double travel_emission_average = car_emissions+bus_emissions+train_emissions;
        
        double elec_car_emissions = car_input*EMISSION_FACTOR_ELECTRIC_CAR;
        double elec_bus_emissions = bus_input*EMISSION_FACTOR_ELECTRIC_BUS;
        double elec_train_emissions = train_input*EMISSION_FACTOR_ELECTRIC_TRAIN;
        double elec_travel_emission_average = elec_car_emissions + elec_bus_emissions + elec_train_emissions;
        double elec_difference = (travel_emission_average*365)-(elec_travel_emission_average*365);
        
        UI.printf("Thank you for answering our questions! Your average travel emissions every day is (if you travel on non-electric vehicles): %5.2f%n", travel_emission_average);
        UI.printf("However, if your travel was run only on electricity (such as electric cars, buses, trains), your average travel emissions would be: %5.2f%n", elec_travel_emission_average);
        UI.printf("While this may not seem like much, it will make a difference longterm like in a year. By travelling electric, the emissions you will save becomes %5.2f%n", elec_difference);
        
        
        
    }
    

    public void setupGUI(){
        UI.initialise();
        UI.addButton("Calculate Emissions", this::calculateEmissions);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1);    // Expand the Text pane
    }

    public static void main(String[] args){
        CarbonEmissionsCalculator cec = new CarbonEmissionsCalculator();
        cec.setupGUI();
    }

}
