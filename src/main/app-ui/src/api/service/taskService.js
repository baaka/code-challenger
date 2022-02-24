import axiosInstance from "../axios";

export const loadTasks = () => {
  return axiosInstance.get("task");
};
