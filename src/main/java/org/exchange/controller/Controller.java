package org.exchange.controller;

import org.exchange.view.View;

import java.util.regex.Pattern;

public class Controller {
    private View view;

    private String codeMoneyBase;
    private String codeMoneyConvert;

    public Controller(){
        codeMoneyBase = "";
        codeMoneyConvert = "";

        view = new View();
        view.launchStart();
        launchProgram();
    }

    private void launchProgram() {
        int control = 0;

        Operation operation;
        operation = new Operation();
        setMoneyValue(operation);

        while (control != 9){
            view.getMenu();
            try{
                control = Integer.parseInt(view.getScanIN("\nIngrese una opcion"));

                launchOptions(control, operation);
            }catch (NumberFormatException e){
                view.sendMessageOUT("Error al ingresar una opción");
                launchProgram();
            }

        }
    }

    public void launchOptions(int option, Operation operation){

        view.sendMessageOUT("Ingrese el primero (2.) la moneda, la cual desea obtener\n y posteriormente (1.) la moneda base.\n " +
                "Puede saltarse el paso (2.) y convertir su moneda base  \n con nuestra lista predeterminadas");


        switch (option) {
            case 1:
                view.sendInfoCodeMoney();
                String codeB = view.getScanIN("Ingrese el codigo ISO de su moneda Base");

                if(!validateCodeIso(codeB) && (validateCodeIso(codeMoneyConvert) || codeMoneyConvert.equals(""))){
                    System.out.println(validateCodeIso(codeB) +" "+ (validateCodeIso(codeMoneyConvert) || codeMoneyConvert.equals("")));
                    view.sendMessageOUT("El codigo es errado, vuelve a intentarlo");
                }else{
                    codeMoneyBase = codeB;
                    operation.setList(codeMoneyBase, codeMoneyConvert);

                }

                break;
            case 2:
                view.sendInfoCodeMoney();
                String codeC = view.getScanIN("Ingrese el codigo ISO de su moneda Base");

                if(!validateCodeIso(codeC)){
                    view.sendMessageOUT("El codigo es errado, vuelve a intentarlo");
                }
                else{
                    codeMoneyConvert = codeC;
                    if(!codeMoneyBase.equals("")){
                        operation.setList(codeMoneyBase, codeMoneyConvert);
                        operateSend(operation,codeMoneyConvert);
                    }else{
                        view.sendMessageOUT("No se ha agregado un código base");
                    }

                }

                break;
            case 3:
                operateSend(operation,"USD");
                break;
            case 4:
                operateSend(operation,"EUR");
                break;
            case 5:
                operateSend(operation,"RUB");
                break;
            case 6:
                operateSend(operation,"GBP");
                break;
            case 7:
                operateSend(operation,"RMB");
                break;
            case 8:
                setMoneyValue(operation);
                break;
            case 9:
                view.sendMessageOUT("Saliendo del programa...");
                break;

            default:
                view.sendMessageOUT("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }
    }

    public void operateSend(Operation operation, String code){
        double value = operation.getOperation(code);

        view.sendMessageOUT("La moneda es: "+operation.getMoney().getMoneyS() + " - " + codeMoneyBase+"\n" +
                "Conversion: "+value + " - " + codeMoneyConvert+"\n");
    }

    public void setMoneyValue(Operation operation){
        try{
        double valueMoney = Integer.parseInt(view.getScanIN("Ingrese el valor que desea convertir\n" +
                "Ejemplo: 21500\n" +
                "Ejemplo: 210.50\n" +
                "Valor: "));
        operation.getMoney().setMoneyS(valueMoney);
        }catch (Exception e){
            view.sendMessageOUT("Error al ingresar el valor intente de nuevo" );
            e.printStackTrace();
            launchProgram();
        }
    }
    public boolean validateCodeIso(String code){
        String regex = "^[A-Z]{3}$";
        return Pattern.matches(regex, code);
    }

}
