package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO car) {
        if (!carRepo.existsById(car.getCarId())){
            carRepo.save(mapper.map(car, Car.class));
        }else {
            throw new RuntimeException(car.getCarId() + " " + "Car Already Exists..!");
        }
    }

    @Override
    public void updateCar(CarDTO car) {
        if (carRepo.existsById(car.getCarId())){
            carRepo.save(mapper.map(car, Car.class));
        }else {
            throw new RuntimeException(car.getCarId() + " " + "No Such Car..! Please Check The Correct Id..!");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (carRepo.existsById(id)){
            carRepo.deleteById(id);
        }else {
            throw new RuntimeException(id + " " + "No Such Car..! Please Check The Correct Id..!");
        }
    }

    @Override
    public CarDTO searchCar(String id) {
        if (carRepo.existsById(id)){
            Car car = carRepo.findById(id).get();
            return mapper.map(car, CarDTO.class);
        }else {
            throw new RuntimeException(id + " " + "No Such Car..! Please Check The Id..!");
        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> all = carRepo.findAll();
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public String generateCarIds() {
        return carRepo.generateCarId();
    }

    @Override
    public String carAvailableOrNot(String available, String id) {
        return carRepo.carAvailableOrNot(available,id);
    }

    @Override
    public int noOfAvailableOrReservedCars(String availableCount) {
        return carRepo.noOfAvailableOrReservedCars(availableCount);
    }

    @Override
    public int needMaintenanceOrUnderMaintenanceCars(String maintain) {
        return carRepo.needMaintenanceOrUnderMaintenanceCars(maintain);
    }

    @Override
    public Double calculateKmUntil5000km(String distance, String carId) {
        return carRepo.calculateKmUntil5000km(distance,carId);
    }

    @Override
    public List<CarDTO> sortAccordingToPassengersByDescending() {
        List<Car> all = carRepo.sortAccordingToPassengersByDescending();
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> sortAccordingToPassengersByAscending() {
        List<Car> all = carRepo.sortAccordingToPassengersByAscending();
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> findByTransmissionType(String type) {
        List<Car> all = carRepo.findByTransmissionType(type);
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> findByBrand(String brand) {
        List<Car> all = carRepo.findByBrand(brand);
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> findByType(String type) {
        List<Car> all = carRepo.findByType(type);
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> findByFuelType(String fuelType) {
        List<Car> all = carRepo.findByFuelType(fuelType);
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<Car> findByColour(String colour) {
        List<Car> all = carRepo.findByColour(colour);
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> sortAccordingToDailyRatePriceByDescending() {
        List<Car> all = carRepo.sortAccordingToDailyRatePriceByDescending();
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> sortAccordingToDailyRatePriceByAscending() {
        List<Car> all = carRepo.sortAccordingToDailyRatePriceByAscending();
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> sortAccordingToMonthlyRatePriceByAscending() {
        List<Car> all = carRepo.sortAccordingToMonthlyRatePriceByAscending();
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }

    @Override
    public List<CarDTO> sortAccordingToMonthlyRatePriceByDescending() {
        List<Car> all = carRepo.sortAccordingToMonthlyRatePriceByDescending();
        return mapper.map(all, new TypeToken<List<CarDTO>>(){
        }.getType());
    }


}
