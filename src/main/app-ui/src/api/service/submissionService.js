import axiosInstance from "../axios";

export const submitSolution = (solution) => {
  return axiosInstance.post("submission", solution);
};

export const getTopSubmitters = () => {
  return axiosInstance.get("submission/top");
};
