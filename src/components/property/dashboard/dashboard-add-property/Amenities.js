import React from "react";

const amenitiesData = {
  column1: [
    { label: "Attic", defaultChecked: false },
    { label: "Quadra de basquete", defaultChecked: true },
    { label: "Ar condicionado", defaultChecked: true },
    { label: "Gramado", defaultChecked: true },
    { label: "Piscina", defaultChecked: false },
    { label: "Churrasqueira", defaultChecked: false },
    { label: "Micro-ondas", defaultChecked: false },
    ],
    column2: [
    { label: "TV a cabo", defaultChecked: false },
    { label: "Secadora", defaultChecked: true },
    { label: "Chuveiro ao ar livre", defaultChecked: true },
    { label: "Máquina de lavar roupa", defaultChecked: true },
    { label: "Academia", defaultChecked: false },
    { label: "Vista para o mar", defaultChecked: false },
    { label: "Espaço privativo", defaultChecked: false },
    ],
    column3: [
    { label: "Vista para o lago", defaultChecked: false },
    { label: "Casa de vinho", defaultChecked: true },
    { label: "Jardim da frente", defaultChecked: true },
    { label: "Refrigerador", defaultChecked: true },
    { label: "WiFi", defaultChecked: false },
    { label: "Lavanderia", defaultChecked: false },
    { label: "Sauna", defaultChecked: false },
    ],
};

const Amenities = () => {
  return (
    <div className="row">
      {Object.keys(amenitiesData).map((columnKey, index) => (
        <div key={index} className="col-sm-6 col-lg-3 col-xxl-2">
          <div className="checkbox-style1">
            {amenitiesData[columnKey].map((amenity, amenityIndex) => (
              <label key={amenityIndex} className="custom_checkbox">
                {amenity.label}
                <input
                  type="checkbox"
                  defaultChecked={amenity.defaultChecked}
                />
                <span className="checkmark" />
              </label>
            ))}
          </div>
        </div>
      ))}
    </div>
  );
};

export default Amenities;
