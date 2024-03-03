"use client";
import Image from "next/image";
import React, { useState } from "react";

const Pricing = () => {
  const pricingPackages = [
    {
      packageTitle: "Básico",
      preço: "Free",
      pricePerMonth: "por mês",
      priceIcon: "images/icon/pricing-icon-2.svg",
      features: [
        "Inscrição padrão de listagem, ativa por 30 dias",
        "Todos os sistemas operacionais são suportados",
        "Ótima interface",
        "Permite criptografia",
        "Sistema reconhecimento facial",
        "Suporte completo 24/7"
      ],
    },
    {
      packageTitle: "Profissional",
      price: "1000 MT",
      pricePerMonth: "por mês",
      priceIcon: "images/icon/pricing-icon-1.svg",
      uniqueClass: "unique-class", // Add a unique class for Professional package
      features: [
        "Inscrição padrão de listagem, ativa por 30 dias",
        "Compatível com todos os sistemas operacionais",
        "Excelente interface",
        "Permite criptografia",
        "Sistema de reconhecimento facial",
        "Suporte completo 24/7"
      ],
    },
    {
      packageTitle: "Business",
      price: "3000 MT",
      pricePerMonth: "por mês",
      priceIcon: "images/icon/pricing-icon-3.svg",
      features: [
        "Inscrição padrão de listagem, ativa por 30 dias",
        "Compatível com todos os sistemas operacionais",
        "Excelente interface",
        "Permite criptografia",
        "Sistema de reconhecimento facial",
        "Suporte completo 24/7"
      ],
    },
  ];

  const [isYearlyBilling, setIsYearlyBilling] = useState(false);

  const handleBillingToggle = () => {
    setIsYearlyBilling((prevIsYearlyBilling) => !prevIsYearlyBilling);
  };

  return (
    <>
      <div className="row" data-aos="fade-up" data-aos-delay="200">
        <div className="col-lg-12">
          <div className="pricing_packages_top d-flex align-items-center justify-content-center mb60">
            <div className="toggle-btn">
              <span className="pricing_save1 ff-heading">Facturado Mensalmente</span>
              <label className="switch">
                <input
                  type="checkbox"
                  id="checkbox"
                  checked={isYearlyBilling}
                  onChange={handleBillingToggle}
                />
                <span className="pricing_table_switch_slide round" />
              </label>
              <span className="pricing_save2 ff-heading">Facturado anualmente</span>
              <span className="pricing_save3">Poupe 20%</span>
            </div>
          </div>
        </div>
      </div>
      {/* End .row */}

      <div className="row" data-aos="fade-up" data-aos-delay="300">
        {pricingPackages.map((item, index) => (
          <div className="col-md-6 col-xl-4" key={index}>
            <div className={`pricing_packages ${index === 1 ? "active" : ""}`}>
              <div className="heading mb60">
                <h4 className={`package_title ${item.uniqueClass || ""}`}>
                  {item.packageTitle}
                </h4>
                <h1 className="text2">
                  {isYearlyBilling
                    ? index === 0
                      ? "Free" // First object shows "Free"
                      : index === 1
                      ? "12000 MT" // Second object shows "$599.95"
                      : "36000 MT" // Third object shows "$999.95"
                    : item.price}
                </h1>
                <p className="text">{item.pricePerMonth}</p>
                <Image
                  width={70}
                  height={70}
                  className="price-icon"
                  src={item.priceIcon}
                  alt="icon"
                />
              </div>
              <div className="details">
                <p className="text mb35">
                  {item.features[0]} {/* Display the first feature */}
                </p>
                <div className="list-style1 mb40">
                  <ul>
                    {item.features.slice(1).map((feature, featureIndex) => (
                      <li key={featureIndex}>
                        <i className="far fa-check text-white bgc-dark fz15" />
                        {feature}
                      </li>
                    ))}
                  </ul>
                </div>
                <div className="d-grid">
                  <a href="#" className="ud-btn btn-thm-border text-thm">
                    Join
                    <i className="fal fa-arrow-right-long" />
                  </a>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
      {/* End .row */}
    </>
  );
};

export default Pricing;
